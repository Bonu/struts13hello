package com.jbonu.servlet;

import org.apache.struts.action.ActionServlet;

public class StrutsActionServlet extends ActionServlet {

    public void addServletMapping(final String urlPattern) {
        this.servletName = "";
        super.addServletMapping(this.servletName, urlPattern);
    }
}
