package ni.edu.uca.myuca

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import ni.edu.uca.myuca.databinding.FragmentHomeBinding
import org.json.JSONArray


class HomeFragment : Fragment() {
    val URL = "http://192.168.1.20:80/Pruebabd_DavidParrales/showCoord.php"


    private lateinit var binding: FragmentHomeBinding
    private var listaCoordinadores: MutableList<Coordinador> = mutableListOf()
    private lateinit var recyclerCoordinador: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getData()
        if(listaCoordinadores.isEmpty())
            setAdapter()
    }

    private fun setAdapter(){
        recyclerCoordinador = binding.rvCoordinadores
        recyclerCoordinador.layoutManager = LinearLayoutManager(context)
        recyclerCoordinador.adapter = RecyclerCoord(binding.root.context, listaCoordinadores)
    }

    private fun getData(){
        var queue = Volley.newRequestQueue(binding.root.context)

        val listener = Response.Listener<String> { response ->
            if(response.isNotEmpty()){
                parseData(response.toString())
                setAdapter()
            }
        }

        val errorListener = Response.ErrorListener { error ->
            Toast.makeText(binding.root.context, "", Toast.LENGTH_SHORT).show()
        }

        var request = object : StringRequest(Request.Method.GET, URL, listener, errorListener){}
        queue.add(request)
    }

    private fun parseData(coordList : String){
        listaCoordinadores = mutableListOf()
        val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
        val coordAdapter : JsonAdapter<CoordinatorAdapter> = moshi.adapter(CoordinatorAdapter::class.java)

        val jsonArray = JSONArray(coordList)
        for(i in 0 until jsonArray.length()){
            val jsonObject = jsonArray.getJSONObject(i)
            val coord = coordAdapter.fromJson(jsonObject.toString())
            if(coord != null) {
                var coordinador : Coordinador = Coordinador(
                    coord?.id,
                    coord?.nombres,
                    coord?.apellidos,
                    coord?.fechaNac,
                    coord?.titulo,
                    coord?.email,
                    coord?.facultad
                )
                addCoords(coordinador)
            }
        }
    }

    private fun addCoords(element : Coordinador){
        listaCoordinadores.add(element)
        println(element)
    }
}