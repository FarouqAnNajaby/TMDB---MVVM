package com.example.repository.repository.local.model

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey


open class Movie : RealmObject() {
    @PrimaryKey
    var id: Int? = null
    var overview: String? = null
    var title: String? = null
    var posterPath: String? = null
    var releaseDate: String? = null
    var popularity: Double? = 0.0
    var adult: Boolean? = null
    var budget: Int? = null
}
