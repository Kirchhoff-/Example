package com.kirchhoff.gmailselectinganimation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.kirchhoff.gmailselectinganimation.adapter.InboxAdapter
import com.kirchhoff.gmailselectinganimation.data.EmailUiModel

private const val KEY_STATE = "presenter-state"

class GmailSelectionActivity : AppCompatActivity(), Presenter.View {

    private val presenter = Presenter()
    private val inboxAdapter = InboxAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gmail_selecting)
        val rvInbox: RecyclerView = findViewById(R.id.rvInbox)
        rvInbox.adapter = inboxAdapter
        presenter.startPresenting(this, savedInstanceState?.getParcelable(KEY_STATE))
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.putParcelable(KEY_STATE, presenter.state())
        super.onSaveInstanceState(outState)
    }

    override fun display(emails: List<EmailUiModel>) = inboxAdapter.submitList(emails)

    override fun openEmail(emailId: String) =
            Toast.makeText(this, "onClick email: $emailId", Toast.LENGTH_SHORT).show()
}