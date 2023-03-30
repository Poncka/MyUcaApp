package ni.edu.uca.myuca

data class Coordinador(
    var id : Int?,
    var nombres : String?,
    var apellidos : String?,
    var fechaNac : String?,
    var titulo : String?,
    var email : String?,
    var facultad : String?) {

    override fun toString(): String {
        return "$id,$nombres,$apellidos,$fechaNac,$titulo,$email,$facultad"
    }

}