package com.goline.goline.view.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.goline.goline.R;

/**
 * Created by danilofernandocavalcanti on 01/12/16.
 */

public class ContatoFragment extends Fragment implements View.OnClickListener {

    private View mView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.mView = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_contato, container, false);
        return this.mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button email =  (Button) mView.findViewById(R.id.buttonSendEmail);
        Button tel   =  (Button) mView.findViewById(R.id.buttonMakePhoneCall);

        email.setOnClickListener(this);
        tel.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent;

        switch (view.getId()) {
            case R.id.buttonSendEmail:
                intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{getString(R.string.text_view_email_address)});
                intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.text_view_contato));
                intent.setType("message/rfc822");

                startActivity(Intent.createChooser(intent, getString(R.string.text_view_choose_email)));
                break;
            case R.id.buttonMakePhoneCall:
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.text_view_phone_number))));
                break;
        }

    }
}
