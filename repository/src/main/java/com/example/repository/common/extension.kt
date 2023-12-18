package com.example.repository.common

import io.realm.RealmList

fun <T> realmListOf(vararg objects: T): RealmList<T> {
    val list = RealmList<T>()
    list.addAll(objects)
    return list
}

fun <T> List<T>.toRealmList(): RealmList<T> {
    val list = RealmList<T>()
    list.addAll(this)
    return list
}