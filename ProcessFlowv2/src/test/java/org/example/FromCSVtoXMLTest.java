package org.example;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.opencsv.CSVReader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.exceptions.verification.TooManyActualInvocations;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
@RunWith(MockitoJUnitRunner.class)
public class FromCSVtoXMLTest {

    @Mock
    private XmlMapper xmlMapper;
    @Mock
    private CsvReaderAdapter csvReaderAdapter;
    @InjectMocks
    private FronCSVtoXML fronCSVtoXML;

    @Test
    public void doIt() throws IOException {
        //GIVEN
        when(csvReaderAdapter.readNext()).thenReturn(new String[] { "valami", "1.0"}).thenReturn(null);

        //WHEN
        fronCSVtoXML.doIt();

        //THEN
        verify(csvReaderAdapter,times(2)).readNext();
        verify(xmlMapper,times(1)).writeValue(any(File.class),any());
    }

    @Test(expected = TooManyActualInvocations.class)
    public void doIt2() throws IOException {
        //GIVEN
        when(csvReaderAdapter.readNext()).thenReturn(new String[] { "valami", "1.0"}).thenReturn(null);

        //WHEN
        fronCSVtoXML.doIt();

        //THEN
        verify(csvReaderAdapter,times(1)).readNext();
        verify(xmlMapper,times(1)).writeValue(any(File.class),any());
    }

    @Test(expected = NumberFormatException.class)
    public void doIt3empty_input() throws IOException {
        //GIVEN
        when(csvReaderAdapter.readNext()).thenReturn(new String[] { "","" }).thenReturn(null);

        //WHEN
        fronCSVtoXML.doIt();

        //THEN
        verify(csvReaderAdapter,times(2)).readNext();
        verify(xmlMapper,times(1)).writeValue(any(File.class),any());
    }

}