package com.kirchhoff.gmailselectinganimation

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.kirchhoff.gmailselectinganimation.adapter.InboxAdapter
import com.kirchhoff.gmailselectinganimation.data.EmailUiModel

private const val KEY_STATE = "presenter-state"

class GmailSelectionActivity : AppCompatActivity(R.layout.activity_gmail_selecting), Presenter.View {

    private val presenter = Presenter()
    private val inboxAdapter = InboxAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val rvInbox: RecyclerView = findViewById(R.id.rvInbox)
        rvInbox.adapter = inboxAdapter
        presenter.startPresenting(this, savedInstanceState?.getParcelable(KEY_STATE))
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putParcelable(KEY_STATE, presenter.state())
        super.onSaveInstanceState(outState)
    }

    override fun display(emails: List<EmailUiModel>) = inboxAdapter.submitList(emails)

    override fun openEmail(emailId: String) =
            Toast.makeText(this, "onClick email: $emailId", Toast.LENGTH_SHORT).show()
}
