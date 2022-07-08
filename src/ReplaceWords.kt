import Utils.println
import java.lang.StringBuilder

class ReplaceWords {
    //c ca  cab
    //cab ca c
    fun replaceWords(dictionary: List<String>, sentence: String): String {
        val rootMap = HashMap<Char, Set<String>>()
        val dictionary = dictionary.sorted()
        for (root in dictionary) {
            val strSet = rootMap.getOrDefault(root[0], mutableSetOf()) as MutableSet<String>
            strSet.add(root)
            rootMap[root[0]] = strSet
        }
        val res = StringBuilder()
        loop@ for (sen in sentence.split(" ")) {
            val rootSet = rootMap.getOrDefault(sen[0], mutableSetOf())
            for (value in rootSet) {
                if (sen.startsWith(value)) {
                    res.append(value)
                    res.append(" ")
                    continue@loop
                }
            }
            res.append(sen)
            res.append(" ")
        }
        return res.toString().substring(0, res.length - 1)
    }
}

fun main() {
    ReplaceWords().replaceWords(listOf("gymth","qglnp","hmgs","rsz","upq","aq","relo","hz","i","atwlc","d","cxax","ymy","hfvr","x","qzgxa","abdgp","dwksr","p","yf","qao","von","bpji","mzxky","tuabq","yquz","j","dzpju","hadfd","svux","rmyku","ae","cr","bowu","slak","s","qvlg","geuw","qx","t","vzix","ycl","xoeyd","cq","jhjm","lt","uye","hwe","rtidu","ksy","dnl","knlsv","yv","ndga","ounoa","kah","dlruh","wbg","vfzt","unnh","kpd","uutv","vxz","lwmh","skyw","f","tktpf","botu","rrs","zdlr","papga","xeyn","z","tqjh","ivzh","b","k","woyl","ixas","tiyd","g","lcq","ta","xd","ztg","oxk","ax","hgqm","dx","zri","heeq","m","q","ub","xxo"),
        "snhaafs hprzyepsgezd ntc ktogne kluwleaobb nwjatqwpx tzobvpylft s jzrlxuzsw fkkjvorqnhpeoikjepmm rxerxpfjssfvtzvunri rpnaizunsjlppuzppf udoqhtcpcv rtegaohvotz eovfuvymmzywjoytegf cztodouflfgc qtom vlyyboks izzhgin rtnrxmm ovtgafmvzu xxeabovlxmy zrqzsexkerfjiqkyjou ygelavmpdncapreadba y kedhgamqyjaffbex fosrpjojgwzjfaoxn pjqysu esaaoksfsvjabdbk e sknkvxxngqpfdkm dmqfzqjuunrbdmkjp fesdkqewhigg anlrixkeqaexh yhmywgpebtsprje tmwbuqnffycjm otfnqgtetdi ovyrmzo vkeze opq rijfryopiizsitum jyz ynoworq xmqohxpgce eblgjvghxxndaqvknph ghhxzfda onukxgjtdrjmoddqhfl xwmutmcvrzkjzxmtz xslacnagnrlu nidcqwrffyrlosnjjl stwperkfcvyzezbebktq fjhb hhxeturoihcdgkkq evzcmxhrnwvnpbbfsm cshlxs qouyuxwdjwyhfp ceiddqqfp pzbsuxqc qgrbisfcnyhdwmbkdjh cxlxqwi z ihgekczvavdwvivvj fjttwiqxqjgakd diggghnustrtizokcrw earkadvle eufogeidbfrcz cnms gomw rbraz bsbopklfbnbbzcod zbayalermeyxn ckrfpylus ofmpofltxmsideqxx rmkqaxda map gvpqwuofuwue o mkzz njrqnwlihegmpmr dbbpwy t c apljlybekb avgxnubzswldzyln tkxwrskwqkzdueuautg cekskcpocbubavun jezsixdu yepzrfdrhqajotjohmzo fleesmkehkvoj ciloebxldjgwtf ruzc tshzh cgudcyfzppgduvfha grcrveutgkz cfsrzt").println()
}