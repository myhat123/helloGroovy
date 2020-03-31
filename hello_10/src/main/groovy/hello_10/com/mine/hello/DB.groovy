package com.mine.hello

import groovy.sql.Sql

class DB {
    Sql sql

    DB() {
        def url = 'jdbc:postgresql://localhost:5432/money'
        def user = 'hjh'
        def password = '1234'
        def driver = 'org.postgresql.Driver'
        sql = Sql.newInstance(url, user, password, driver)
    }

    //list子元素是map
    def getQryDtl(String tranDate, Integer flag) {
        List qry_dtl = sql.rows("""
            SELECT acc, tran_date, amt, dr_cr_flag, rpt_sum, timestampl
            FROM brch_qry_dtl
            where tran_date=cast(? as date) and dr_cr_flag=?
        """, [tranDate, flag])

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
