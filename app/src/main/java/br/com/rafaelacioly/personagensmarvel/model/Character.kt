package br.com.rafaelacioly.personagensmarvel.model

import android.os.Parcel
import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(value = ["comics", "series", "stories", "events", "urls"])
data class Character(
    var id          : Int?          = null,
    var name        : String?       = null,
    var description : String?       = null,
    var modified    : String?       = null,
    var thumbnail   : Thumbnail?    = null,
    var resourceURI : String?       = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readParcelable(Thumbnail::class.java.classLoader),
        parcel.readString()
    ) {
    }

    override fun toString(): String {
        return "$name"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeString(modified)
        parcel.writeParcelable(thumbnail, flags)
        parcel.writeString(resourceURI)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Character> {
        override fun createFromParcel(parcel: Parcel): Character {
            return Character(parcel)
        }

        override fun newArray(size: Int): Array<Character?> {
            return arrayOfNulls(size)
        }
    }
}

