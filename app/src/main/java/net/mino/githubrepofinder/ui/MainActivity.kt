package net.mino.githubrepofinder.ui


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import net.mino.githubrepofinder.R

class MainActivity : AppCompatActivity() {
    private var fragment: Fragment? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragment = supportFragmentManager.findFragmentByTag("fragment")

        if (fragment == null) {
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.container, RepoFragment(), "fragment")
                    .commit()
        }
    }
}
