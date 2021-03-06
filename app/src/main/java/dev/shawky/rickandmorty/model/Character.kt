package dev.shawky.rickandmorty.model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import dev.shawky.rickandmorty.model.remote.Location
import dev.shawky.rickandmorty.model.remote.Origin

@Entity
data class Character(
    var created: String?,
    @Ignore
    var episode: List<String>?,
    var gender: String?,
    @PrimaryKey
    var id: Int?,
    var image: String?,
    @Ignore
    var location: Location?,
    var name: String?,
    @Ignore
    var origin: Origin?,
    var species: String?,
    var status: String?,
    var type: String?,
    var url: String?,
    var page:Int?,
    @Ignore
    var genderColor:Int?,
    @Ignore
    var statusColor:Int?,
) {
    constructor():this(null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)

    fun setGenderColor() {
        if(gender == "Male"){
            genderColor=android.R.color.holo_red_light;
        }else if (gender =="Female"){
            genderColor=android.R.color.holo_blue_light;
        }
    }

    fun setStatusColor(){
        if(status =="Alive"){
            statusColor = android.R.color.holo_green_light;
        }else if (status == "Dead"){
            statusColor = android.R.color.holo_red_dark;
        }
    }

}