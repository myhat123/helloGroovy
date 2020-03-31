import groovy.sql.Sql

def url = 'jdbc:postgresql://localhost:5432/money'
def user = 'hjh'
def password = '1234'
def driver = 'org.postgresql.Driver'
def sql = Sql.newInstance(url, user, password, driver)

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

sql.connection.autoCommit = false

new File("./data.csv").eachLine { line ->
    def x = line.split(",")
    sql.execute """
        INSERT INTO brch_qry_dtl (tran_date, timestampl, acc, amt, dr_cr_flag, rpt_sum)
        VALUES (?::date, ?, ?, ?, ?, ?);
    """, [x[0], x[1], x[2], x[3].toFloat(), x[4].toInteger(), x[5]]
}

sql.commit()