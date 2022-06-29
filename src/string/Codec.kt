package string

import kotlin.random.Random

/**
 * 535. TinyURL 的加密与解密
 * 短链接算法
 */
class Codec {
    val origin2Tiny = HashMap<String, String>()
    val tiny2Origin = HashMap<String, String>()
    val prefix = "http://www.codec.com/"
    val str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890"
    val k = 6

    // Encodes a URL to a shortened URL.
    fun encode(longUrl: String): String {
        while (!origin2Tiny.containsKey(longUrl)) {
            val ch = CharArray(k)
            for (i in 0 until k) {
                ch[i] = str[Random.nextInt(str.length)]
            }
            val encodedUrl = prefix + String(ch)
            if (tiny2Origin.containsKey(encodedUrl)) {
                continue
            }
            origin2Tiny[longUrl] = encodedUrl
            tiny2Origin[encodedUrl] = longUrl
        }
        return origin2Tiny[longUrl]!!
    }

    // Decodes a shortened URL to its original URL.
    fun decode(shortUrl: String): String {
        return tiny2Origin[shortUrl]!!
    }
}

fun main() {
    val codec = Codec()
    val encoded = codec.encode("12312312")
    println(encoded)
    println(codec.decode(encoded))
}