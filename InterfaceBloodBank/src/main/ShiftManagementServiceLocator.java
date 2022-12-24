/**
 * ShiftManagementServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package main;

public class ShiftManagementServiceLocator extends org.apache.axis.client.Service implements main.ShiftManagementService {

    public ShiftManagementServiceLocator() {
    }


    public ShiftManagementServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ShiftManagementServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ShiftManagement
    private java.lang.String ShiftManagement_address = "http://localhost:8080/BloodBank/services/ShiftManagement";

    public java.lang.String getShiftManagementAddress() {
        return ShiftManagement_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ShiftManagementWSDDServiceName = "ShiftManagement";

    public java.lang.String getShiftManagementWSDDServiceName() {
        return ShiftManagementWSDDServiceName;
    }

    public void setShiftManagementWSDDServiceName(java.lang.String name) {
        ShiftManagementWSDDServiceName = name;
    }

    public main.ShiftManagement getShiftManagement() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ShiftManagement_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getShiftManagement(endpoint);
    }

    public main.ShiftManagement getShiftManagement(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            main.ShiftManagementSoapBindingStub _stub = new main.ShiftManagementSoapBindingStub(portAddress, this);
            _stub.setPortName(getShiftManagementWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setShiftManagementEndpointAddress(java.lang.String address) {
        ShiftManagement_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (main.ShiftManagement.class.isAssignableFrom(serviceEndpointInterface)) {
                main.ShiftManagementSoapBindingStub _stub = new main.ShiftManagementSoapBindingStub(new java.net.URL(ShiftManagement_address), this);
                _stub.setPortName(getShiftManagementWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ShiftManagement".equals(inputPortName)) {
            return getShiftManagement();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://main", "ShiftManagementService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://main", "ShiftManagement"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ShiftManagement".equals(portName)) {
            setShiftManagementEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
