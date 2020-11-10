package test.test.apimarveltest.view.listCharacter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import test.test.apimarveltest.R
import test.test.apimarveltest.remoteDataSource.model.CharacterModel

class AdapterCharacterList(
    private val items: MutableList<CharacterModel>,
    private val context: Fragment
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.card_item_character, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is MyViewHolder -> {
                holder.bind(items[position])
            }
        }

        holder.itemView.setOnClickListener{
            val id = items[position].id

            val action = CharacterListFragmentDirections.actionCharacterListFragmentToCharacterDetailsFragment(id = id)
            findNavController(context).navigate(action)

        }

    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class MyViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val name = itemView.findViewById<TextView>(R.id.nameCharacterTextView)

    fun bind(characterModel: CharacterModel){
          name.text = characterModel.name
    }
}

