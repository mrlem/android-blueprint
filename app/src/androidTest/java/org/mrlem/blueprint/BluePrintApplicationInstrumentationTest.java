package org.mrlem.blueprint;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.MediumTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;


import static org.junit.Assert.*;


@MediumTest
@RunWith(AndroidJUnit4.class)
public class BluePrintApplicationInstrumentationTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("org.mrlem.blueprint", appContext.getPackageName());
    }
}