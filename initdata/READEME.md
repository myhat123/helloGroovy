import groovy.sql.Sql

def url = 'jdbc:postgresql://localhost:5432/money'
def user = 'hjh'
def password = '1234'
def driver = 'org.postgresql.Driver'
def sql = Sql.newInstance(url, user, password, driver)

new File("./data.csv").eachLine { line ->
    def r = line.split(",")
    sql.execute '''
        INSERT INTO brch_qry_dtl (tran_date, timestampl, acc, amt, dr_cr_flag, rpt_sum)
        VALUES (?, ?, ?, ?, ?);
    ''', [x[0], x[1], x[2], x[3], x[4], x[5]]
}