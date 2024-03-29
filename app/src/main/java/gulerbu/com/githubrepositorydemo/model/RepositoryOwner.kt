package gulerbu.com.githubrepositorydemo.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class RepositoryOwner(
    @SerializedName("login")
    val userName: String,
    @SerializedName("avatar_url")
    val userAvatarUrl: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(userName)
        parcel.writeString(userAvatarUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RepositoryOwner> {
        override fun createFromParcel(parcel: Parcel): RepositoryOwner {
            return RepositoryOwner(parcel)
        }

        override fun newArray(size: Int): Array<RepositoryOwner?> {
            return arrayOfNulls(size)
        }
    }
}