package com.mine.hello

import groovy.sql.Sql
import org.apache.groovy.dateutil.extensions.*

class DB {
    Sql sql

    DB() {
        def url = 'jdbc:postgresql://localhost:5432/money'
        def user = 'hjh'
        def password = '1234'
        def driver = 'org.postgresql.Driver'
        sql = Sql.newInstance(url, user, password, driver)
    }

    def create() {
        sql.execute """
            DROP TABLE if exists brch_qry_dtl;
        """

        sql.execute """
            create table brch_qry_dtl (
                acc character varying(19), 
                tran_date date, 
                amt numeric(16,2), 
                dr_cr_flag integer, 
                rpt_sum character varying(8), 
                timestampl character varying(14)
            );
        """
    }

    def loaddata() {
        sql.connection.autoCommit = false

        def url = getClass().getResource('/data.csv')
        //new File("/home/hzg/work/helloGroovy/initdata/data.csv").eachLine { line ->
        url.eachLine { line ->
            def x = line.split(",")
            sql.execute """
                INSERT INTO brch_qry_dtl (tran_date, timestampl, acc, amt, dr_cr_flag, rpt_sum)
                VALUES (?::date, ?, ?, ?, ?, ?);
            """, [x[0], x[1], x[2], x[3].toFloat(), x[4].toInteger(), x[5]]
        }

        sql.commit()
    }

    //list子元素是map
    def getQryDtl(String tranDate, Integer flag) {
        def x = DateUtilStaticExtensions.parse(new java.util.Date(), 'yyyy-MM-dd', tranDate)
        def y = new java.sql.Date(x.getTime())

        List qry_dtl = sql.rows("""
            SELECT acc, tran_date, amt, dr_cr_flag, rpt_sum, timestampl
            FROM brch_qry_dtl
            where tran_date=? and dr_cr_flag=?
        """, [y, flag])

        List results = qry_dtl.collect { 
            ['acc': it.acc, 'tran_date': it.tran_date, 'amt': it.amt, 'rpt_sum': it.rpt_sum] 
        }
        return results
    }

    //list子元素是对象
    def getQryDtl_02(String tranDate, Integer flag) {
        List qry_dtl = sql.rows("""
            SELECT acc, tran_date, amt, dr_cr_flag, rpt_sum, timestampl
            FROM brch_qry_dtl
            where tran_date=cast(? as date) and dr_cr_flag=?
        """, [tranDate, flag])

        List results = []
        qry_dtl.each() { 
            def x = new QryDtl()
            x.acc = it.acc
            x.tranDate = it.tran_date
            x.amt = it.amt
            x.rptSum = it.rpt_sum
            results += x
        }
        return results
    }
}
