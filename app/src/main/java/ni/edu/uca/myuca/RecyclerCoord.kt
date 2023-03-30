package ni.edu.uca.myuca

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerCoord (var context: Context, var listaCoordinadores : MutableList<Coordinador>) : RecyclerView.Adapter<RecyclerCoord.MyHolder>(){

    inner class MyHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var tvId : TextView
        var tvNombres : TextView
        var tvApellidos : TextView
        var tvFechaNac : TextView
        var tvTitulo : TextView
        var tvEmail : TextView
        var tvFacultad : TextView

        init {
            tvId = itemView.findViewById(R.id.idCtv)
            tvNombres = itemView.findViewById(R.id.nombrestv)
            tvApellidos = itemView.findViewById(R.id.apellidostv)
            tvFechaNac = itemView.findViewById(R.id.fechaNactv)
            tvTitulo = itemView.findViewById(R.id.titulotv)
            tvEmail = itemView.findViewById(R.id.emailtv)
            tvFacultad = itemView.findViewById(R.id.facultadtv)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.coorditems,parent,false)
        return MyHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var coordinador = listaCoordinadores[position]

        with(coordinador){
            holder.tvId.text = id.toString()
            holder.tvNombres.text = nombres
            holder.tvApellidos.text = apellidos
            holder.tvEmail.text = email
            holder.tvFacultad.text = facultad
            holder.tvTitulo.text = titulo

        }

    }

    override fun getItemCount(): Int {
        return listaCoordinadores.size
    }

}