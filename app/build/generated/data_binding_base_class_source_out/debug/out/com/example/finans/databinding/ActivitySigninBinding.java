// Generated by view binder compiler. Do not edit!
package com.example.finans.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.finans.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivitySigninBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button buttonSignup;

  @NonNull
  public final EditText editTextMail;

  @NonNull
  public final EditText editTextPassword;

  @NonNull
  public final EditText editTextUsername;

  @NonNull
  public final TextView textViewLoginLink;

  @NonNull
  public final TextView textViewTitle;

  private ActivitySigninBinding(@NonNull LinearLayout rootView, @NonNull Button buttonSignup,
      @NonNull EditText editTextMail, @NonNull EditText editTextPassword,
      @NonNull EditText editTextUsername, @NonNull TextView textViewLoginLink,
      @NonNull TextView textViewTitle) {
    this.rootView = rootView;
    this.buttonSignup = buttonSignup;
    this.editTextMail = editTextMail;
    this.editTextPassword = editTextPassword;
    this.editTextUsername = editTextUsername;
    this.textViewLoginLink = textViewLoginLink;
    this.textViewTitle = textViewTitle;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivitySigninBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivitySigninBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_signin, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivitySigninBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.buttonSignup;
      Button buttonSignup = ViewBindings.findChildViewById(rootView, id);
      if (buttonSignup == null) {
        break missingId;
      }

      id = R.id.editTextMail;
      EditText editTextMail = ViewBindings.findChildViewById(rootView, id);
      if (editTextMail == null) {
        break missingId;
      }

      id = R.id.editTextPassword;
      EditText editTextPassword = ViewBindings.findChildViewById(rootView, id);
      if (editTextPassword == null) {
        break missingId;
      }

      id = R.id.editTextUsername;
      EditText editTextUsername = ViewBindings.findChildViewById(rootView, id);
      if (editTextUsername == null) {
        break missingId;
      }

      id = R.id.textViewLoginLink;
      TextView textViewLoginLink = ViewBindings.findChildViewById(rootView, id);
      if (textViewLoginLink == null) {
        break missingId;
      }

      id = R.id.textViewTitle;
      TextView textViewTitle = ViewBindings.findChildViewById(rootView, id);
      if (textViewTitle == null) {
        break missingId;
      }

      return new ActivitySigninBinding((LinearLayout) rootView, buttonSignup, editTextMail,
          editTextPassword, editTextUsername, textViewLoginLink, textViewTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
