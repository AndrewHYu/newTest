package hospitalData;

import ca.uhn.hl7v2.AcknowledgmentCode;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.Location;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.MessageVisitor;
import ca.uhn.hl7v2.model.Structure;
import ca.uhn.hl7v2.parser.Parser;

import java.io.IOException;

/**
 * @author Andrew
 * @date 2017/11/27
 */
public class MyMessage implements Message {
    @Override
    public String getVersion() {
        return null;
    }

    @Override
    public Character getFieldSeparatorValue() throws HL7Exception {
        return null;
    }

    @Override
    public String getEncodingCharactersValue() throws HL7Exception {
        return null;
    }

    @Override
    public void setParser(Parser parser) {

    }

    @Override
    public Parser getParser() {
        return null;
    }

    @Override
    public void parse(String s) throws HL7Exception {

    }

    @Override
    public String encode() throws HL7Exception {
        return null;
    }

    @Override
    public Message generateACK() throws HL7Exception, IOException {
        return null;
    }

    @Override
    public Message generateACK(String s, HL7Exception e) throws HL7Exception, IOException {
        return null;
    }

    @Override
    public Message generateACK(AcknowledgmentCode acknowledgmentCode, HL7Exception e) throws HL7Exception, IOException {
        return null;
    }

    @Override
    public String printStructure() throws HL7Exception {
        return null;
    }

    @Override
    public Structure[] getAll(String s) throws HL7Exception {
        return new Structure[0];
    }

    @Override
    public Structure get(String s) throws HL7Exception {
        return null;
    }

    @Override
    public Structure get(String s, int i) throws HL7Exception {
        return null;
    }

    @Override
    public boolean isRequired(String s) throws HL7Exception {
        return false;
    }

    @Override
    public boolean isRepeating(String s) throws HL7Exception {
        return false;
    }

    @Override
    public boolean isChoiceElement(String s) throws HL7Exception {
        return false;
    }

    @Override
    public boolean isGroup(String s) throws HL7Exception {
        return false;
    }

    @Override
    public String[] getNames() {
        return new String[0];
    }

    @Override
    public Class<? extends Structure> getClass(String s) {
        return null;
    }

    @Override
    public String addNonstandardSegment(String s) throws HL7Exception {
        return null;
    }

    @Override
    public String addNonstandardSegment(String s, int i) throws HL7Exception {
        return null;
    }

    @Override
    public Message getMessage() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Group getParent() {
        return null;
    }

    @Override
    public boolean accept(MessageVisitor messageVisitor, Location location) throws HL7Exception {
        return false;
    }

    @Override
    public Location provideLocation(Location location, int i, int i1) {
        return null;
    }

    @Override
    public boolean isEmpty() throws HL7Exception {
        return false;
    }
}
