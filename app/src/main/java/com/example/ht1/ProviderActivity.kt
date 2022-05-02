package com.example.ht1

import android.Manifest.permission.READ_CONTACTS
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.ht1.databinding.ActivityProviderBinding

//content provider позволяет создавать бд, к которой могут иметь доступ другие приложения
//в этом активити будем получать данные из контактов и добавлять их туда же

private lateinit var binding: ActivityProviderBinding
class ProviderActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProviderBinding.inflate(layoutInflater)
        setContentView(binding.root)

            //запрос доступа к контактам
            //при первом запуске нужно предоставить доступ к контактам для корректной работы приложения
        ActivityCompat.requestPermissions(this, arrayOf(READ_CONTACTS), 1)

        getContacts()

    }

    private val cList = mutableListOf<String>()


    //получения списка контактов
    @SuppressLint("Range")
    @RequiresApi(Build.VERSION_CODES.O)
    fun getContacts() {
        //обращаемся к контенту из контактов
        val cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI,null,null,null)
        if (cursor != null  && cursor.moveToFirst()) {
            var name: String
            do {
                name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
                Log.d("getContacts", name)
                cList.add(name)
            }while (cursor.moveToNext())
            cursor.close()
        }
        val adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,cList)
        binding.contactsList.adapter = adapter
    }


    //добавление нового контакта
    fun addContact(view: View) {
        //шлем интент к контактам с целью создания нового
        val intent = Intent(ContactsContract.Intents.Insert.ACTION)
        intent.type = ContactsContract.RawContacts.CONTENT_TYPE
            //указываем номер и почту
        intent.putExtra(ContactsContract.Intents.Insert.EMAIL, binding.email.text)
        intent.putExtra(ContactsContract.Intents.Insert.PHONE, binding.pNumber.text)
        startActivity(intent)
    }
}

