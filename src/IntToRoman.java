public class IntToRoman {
    /*
    * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：

I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
    *
    * */
    public static void main(String[] args) {

    }

    public String intToRoman(int num) {
        if (num == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        int i = num / 10;



        return intToRoman(i) + result;
    }

    public String appendStrWithTimes(char c,int times){
        return "";
    }

    /*

        switch (i) {
            case 1:
                result.append("I");
                break;
            case 2:
                result.append("II");
                break;
            case 3:
                result.append("III");
                break;
            case 4:
                result.append("IV");
                break;
            case 5:
                result.append("V");
                break;
            case 6:
                result.append("VI");
                break;
            case 7:
                result.append("VI");
                break;
            case 8:
                result.append("VI");
                break;
            case 9:
                result.append("VI");
                break;
        }


    * */
}
