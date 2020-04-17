package br.com.rafaelacioly.personagensmarvel.model

import java.math.BigInteger
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

class AuthAPI{

    val publicKey   : String = "bf0a75e351a5cfed0d01dc5ec3f9cf3a"
    val privateKey  : String = "22f386501398f8d24815733b91bde885b4b6d96c"
    val timeStamp   : String = System.currentTimeMillis().toString()
    var limit       : String = "100"

    fun md5Hash(): String? {
        val hash : String = timeStamp+privateKey+publicKey
        var m: MessageDigest? = null
        try {
            m = MessageDigest.getInstance("MD5")
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }
        m?.update(hash.toByteArray(), 0, hash.length)
        val md5 = BigInteger(1, m?.digest()).toString(16)
        return md5
    }
}