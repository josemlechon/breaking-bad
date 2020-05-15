package com.jml.breaking.bad.common.ui.widget

import android.view.View
import android.view.ViewGroup
import com.jml.breaking.bad.R
import com.jml.breaking.bad.characters.domain.model.CharacterSeries
import com.jml.breaking.bad.characters.ui.widget.BaseRecyclerAdapter
import com.jml.breaking.bad.common.extensions.inflate
import com.jml.breaking.bad.common.extensions.loadCircleFromUrl
import com.jml.breaking.bad.common.extensions.setClickListener
import kotlinx.android.synthetic.main.item_character.view.*

class CharactersAdapter :
    BaseRecyclerAdapter<BaseRecyclerAdapter.BaseViewHolder<CharacterSeries>, CharacterSeries>() {

    var doOnItemClick: ((position: Int, character: CharacterSeries) -> Unit)? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CharacterVH {
        return CharacterVH(parent.inflate(R.layout.item_character))
    }

   inner class CharacterVH(itemView: View) :
        BaseRecyclerAdapter.BaseViewHolder<CharacterSeries>(itemView) {

        override fun bind(item: CharacterSeries) {

            itemView.apply {

                item_character_image.loadCircleFromUrl(item.image)

                item_character_title_text.text = item.name
                item_character_nickname_text.text = item.nickname
                item_character_birthday_text.text = item.birthday

                setClickListener(::onItemClick)
            }
        }

        private fun onItemClick() {
            getItem(adapterPosition)
                ?.takeIf { doOnItemClick != null }
                ?.let {
                    doOnItemClick?.invoke(adapterPosition, it )
                }
        }
    }
}