package com.youngtard.githubtrendingandroid

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.text.HtmlCompat
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
        tv_repo_name.text = HtmlCompat.fromHtml("<b>Repo Name: </b>${intent.getStringExtra("repo_name")}", HtmlCompat.FROM_HTML_MODE_LEGACY)
        tv_description.text = HtmlCompat.fromHtml("<b>Description: </b>${intent.getStringExtra("description")}", HtmlCompat.FROM_HTML_MODE_LEGACY)
        tv_stars.text = HtmlCompat.fromHtml("<b>Stars: </b>${intent.getStringExtra("stars")}", HtmlCompat.FROM_HTML_MODE_LEGACY)
        tv_language.text = HtmlCompat.fromHtml("<b>Language:</b> ${intent.getStringExtra("language")}", HtmlCompat.FROM_HTML_MODE_LEGACY)
        tv_forks.text = HtmlCompat.fromHtml("<b>Forks: </b>${intent.getStringExtra("forks")}", HtmlCompat.FROM_HTML_MODE_LEGACY)
        tv_repo_link.text = HtmlCompat.fromHtml("<u>${intent.getStringExtra("repo_url")}</u>", HtmlCompat.FROM_HTML_MODE_LEGACY)
        tv_user_profile_link.text = HtmlCompat.fromHtml("<u>${intent.getStringExtra("user_profile_url")}</u>", HtmlCompat.FROM_HTML_MODE_LEGACY)


    }
}
