package ru.pa4ok.demoexam.util;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BaseSubForm<T extends BaseForm> extends BaseForm
{
    protected T mainForm;

    public BaseSubForm(T mainForm, int width, int height)
    {
        super(width, height);
        this.mainForm = mainForm;

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeSubForm();
            }
        });

        mainForm.setEnabled(false);
    }

    public void closeSubForm()
    {
        dispose();
        mainForm.setEnabled(true);
        mainForm.toFront();
        mainForm.requestFocus();
    }
}
