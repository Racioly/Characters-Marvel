package br.com.rafaelacioly.personagensmarvel.ui.mian.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import br.com.rafaelacioly.personagensmarvel.R
import br.com.rafaelacioly.personagensmarvel.model.Character
import br.com.rafaelacioly.personagensmarvel.ui.details.DetailsActivity
import com.facebook.drawee.view.SimpleDraweeView

class CharacterAdapter(private val context: Context, private val characters: List<Character>): RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var thumbnail   = view.findViewById< SimpleDraweeView > (R.id.imvThumbRecycler )
        var name        = view.findViewById< TextView >         (R.id.txvNameRecycler  )
        var card        = view.findViewById< CardView >         (R.id.cdvRecycler      )
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.view_recycler, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = characters.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.thumbnail.setImageURI(Uri.parse(characters[position].thumbnail.toString()),context)
        holder.name.text = characters[position].name
        holder.card.setOnClickListener {
            var character: Character = characters[position]
            context.startActivity(
                Intent(context, DetailsActivity::class.java).apply {
                    putExtra("character", character)
                }
            )
        }
    }

}