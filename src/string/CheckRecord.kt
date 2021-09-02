package string

//551. 学生出勤记录 I
class CheckRecord {
    fun checkRecord(s: String): Boolean {
        var A = 0
        var L = 0
        for (ch in s) {
            if (ch == 'A') {
                A++
                L = 0
                if (A>=2){
                    return false
                }
            } else if (ch == 'L') {
                L++
                if (L == 3){
                    return false
                }
            }else{
                L = 0
            }
        }
        return true
    }
}