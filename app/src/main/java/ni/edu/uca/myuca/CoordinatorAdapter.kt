package ni.edu.uca.myuca

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CoordinatorAdapter (
    @Json(name = "id") var id: Int,
    @Json(name = "nombres") var nombres: String,
    @Json(name = "apellidos") var apellidos: String,
    @Json(name = "fechaNac") var fechaNac: String,
    @Json(name = "titulo") var titulo: String,
    @Json(name = "email") var email: String,
    @Json(name = "facultad") var facultad: String,
)
