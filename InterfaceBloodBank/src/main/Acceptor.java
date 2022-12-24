/**
 * Acceptor.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package main;

public interface Acceptor extends java.rmi.Remote {
    public java.lang.String acceptorRegistration(java.lang.String name, java.lang.String address, java.lang.String bloodType, java.lang.String phone, int quantity, java.lang.String medicalCondition) throws java.rmi.RemoteException;
}
