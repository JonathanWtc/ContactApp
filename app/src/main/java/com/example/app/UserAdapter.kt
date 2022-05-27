package com.example.app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app.databinding.ItemUserBinding
import com.example.app.models.UserDetailsModel
import com.example.app.models.UserResponse

class UserAdapter (private val usersList : List<UserDetailsModel>): RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    inner class UserViewHolder(val binding: ItemUserBinding): RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        // holder.binding.tvName.text = usersList[position].toString()
        with(holder){
            with(usersList[position]){
                binding.tvId.text = id.toString()
                binding.tvName.text = name
                binding.tvLastName.text = lastName
                binding.tvNickName.text = nickName
            }
        }
    }

    override fun getItemCount(): Int = usersList.size
}