package com.email_client.controller;

import com.email_client.EmailManager;
import com.email_client.view.ViewFactory;

public abstract class BaseController {

    protected EmailManager emailManager;

    protected ViewFactory viewFactory;

    private String fxmlName;

    public BaseController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
        this.emailManager = emailManager;
        this.viewFactory = viewFactory;
        this.fxmlName = fxmlName;
    }

    public String getFxmlName() {
        return fxmlName;
    }
}
