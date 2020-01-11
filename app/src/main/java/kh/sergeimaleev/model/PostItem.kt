package kh.sergeimaleev.model

import com.google.gson.annotations.SerializedName

data class PostItem(
    @SerializedName("id")
    val id: String = "",
    @SerializedName("date")
    val date: Long = 0L,
    @SerializedName("liked_by")
    val likedBy: List<String> = listOf(),
    @SerializedName("photos")
    val photos: List<PhotoItem> = listOf(),
    @SerializedName("tags")
    val tags: List<String> = listOf(),
    @SerializedName("user_avatar")
    val userAvatar: String = "",
    @SerializedName("user_name")
    val userName: String = "",
    @SerializedName("user_place")
    val userPlace: String = ""
)