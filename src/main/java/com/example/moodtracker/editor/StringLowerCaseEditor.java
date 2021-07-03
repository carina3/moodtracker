package com.example.moodtracker.editor;

import java.beans.PropertyEditorSupport;

public class StringLowerCaseEditor extends PropertyEditorSupport {
    @Override
    public String getAsText()
    {
        return getValue().toString();
    }

    @Override
    public void setAsText( String text ) throws IllegalArgumentException
    {
        setValue( text.toLowerCase() );
    }
}
