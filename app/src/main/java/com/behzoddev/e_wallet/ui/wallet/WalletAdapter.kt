package com.behzoddev.e_wallet.ui.wallet

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.behzoddev.e_wallet.R
import com.behzoddev.e_wallet.common.extensions.convertToString
import com.behzoddev.e_wallet.data.local.TransactionModel
import com.behzoddev.e_wallet.databinding.ItemTransactionBinding

class WalletAdapter : RecyclerView.Adapter<WalletAdapter.WalletViewHolder>() {

    inner class WalletViewHolder(val binding: ItemTransactionBinding) :
        RecyclerView.ViewHolder(binding.root)

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<TransactionModel>() {
            override fun areItemsTheSame(
                oldItem: TransactionModel,
                newItem: TransactionModel
            ): Boolean {
                return oldItem.transactionId == oldItem.transactionId
            }

            override fun areContentsTheSame(
                oldItem: TransactionModel,
                newItem: TransactionModel
            ): Boolean {
                return oldItem.transactionAmount == newItem.transactionAmount
                        && oldItem.transactionType == newItem.transactionType
                        && oldItem.transactionTitle == newItem.transactionTitle
            }
        }
    }

    val differ = AsyncListDiffer(this, diffUtil)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WalletViewHolder {
        val binding =
            ItemTransactionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WalletViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WalletViewHolder, position: Int) {
        val item = differ.currentList[position]
        holder.binding.apply {
            itemTitle.text = item.transactionTitle
            itemCategory.text = item.transactionType
            itemDate.text = item.transactionDate

            when (item.transactionType) {
                "Income" -> {
                    itemAmount.text = "+".plus(convertToString(item.transactionAmount))
                }
                "Expense" -> {
                    itemAmount.text = "-".plus(convertToString(item.transactionAmount))
                }
            }
            when (item.transactionTag) {
                "Housing" -> {
                    itemIcon.setImageResource(R.drawable.ic_housing)
                }
                "Transportation" -> {
                    itemIcon.setImageResource(R.drawable.ic_transport)
                }
                "Food" -> {
                    itemIcon.setImageResource(R.drawable.ic_food)
                }
                "Utilities" -> {
                    itemIcon.setImageResource(R.drawable.ic_utilities)
                }
                "Insurance" -> {
                    itemIcon.setImageResource(R.drawable.ic_insurance)
                }
                "Healthcare" -> {
                    itemIcon.setImageResource(R.drawable.ic_medical)
                }
                "Personal Spending" -> {
                    itemIcon.setImageResource(R.drawable.ic_personal_spending)
                }
                else -> {
                    itemIcon.setImageResource(R.drawable.ic_personal_spending)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}