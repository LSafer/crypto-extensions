package net.lsafer.crypto

import at.favre.lib.crypto.bcrypt.BCrypt

private val BCRYPT_HASHER: BCrypt.Hasher = BCrypt.withDefaults()
private val BCRYPT_VERIFIER: BCrypt.Verifyer = BCrypt.verifyer()

fun bcryptHash(password: String, cost: Int): String {
    val pwdBytes = password.toByteArray()
    val out = BCRYPT_HASHER.hash(cost, pwdBytes)
    return out.decodeToString()
}

fun bcryptCheck(password: String, hash: String): Boolean {
    val pwdBytes = password.toByteArray()
    val hashBytes = hash.toByteArray()
    val out = BCRYPT_VERIFIER.verify(pwdBytes, hashBytes)
    return out.verified
}
