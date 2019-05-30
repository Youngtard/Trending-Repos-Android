package com.youngtard.githubtrendingandroid

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_repo_detail.*
import java.net.URI

class RepoDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repo_detail)

        supportActionBar?.title = "Details"

    }

    override fun onResume() {
        super.onResume()

//        img_avatar.setImageURI(Uri.parse(intent.getStringExtra("avatar_url")) )
        Picasso.get().load(intent.getStringExtra("avatar_url")).into(img_avatar)
        tv_username.text = intent.getStringExtra("username")
        tv_repo_name.text = "Repo Name: ${intent.getStringExtra("repo_name")}"
        tv_description.text = "Description: ${intent.getStringExtra("description")}"
        tv_stars.text = "Stars: ${intent.getStringExtra("stars")}"
    }
}
