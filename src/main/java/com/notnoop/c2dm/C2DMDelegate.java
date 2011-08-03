/*
 * Copyright 2011, Mahmood Ali.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *   * Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *   * Redistributions in binary form must reproduce the above
 *     copyright notice, this list of conditions and the following disclaimer
 *     in the documentation and/or other materials provided with the
 *     distribution.
 *   * Neither the name of Mahmood Ali. nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.notnoop.c2dm;

public interface C2DMDelegate {
    /**
     * Delegate called when a notification is sent successfully to the Google
     * C2DM servers.
     *
     * @param message   the sent message (null if client didn't create a
     *              {@link C2DMNotification} object)
     * @param response  the response Google sent
     * @param id    the id assigned to the message by Google servers
     */
    public void messageSent(C2DMDeviceNotification message, C2DMResponse response, String id);

    /**
     * Delegate method called when the C2DM server rejects or drops a message.
     *
     * The server may drop the message for various reasons.  Some may require
     * the application to retry (e.g. when servers are down or over quota),
     * and some require more work (e.g. invalid authentication, missing values).
     *
     * @param message   the sent message (null if client didn't create a
     *              {@link C2DMNotification} object)
     * @param response  the response Google sent
     */
    public void messageFailed(C2DMDeviceNotification message, C2DMResponse response);

    /**
     * Delegate method called when Google servers update the Auth Token.
     *
     * Google servers update the authentication code, and indicates the new
     * value in special HTTP header "Update-Client-Auth".  Google C2DM servers
     * may accept the stale value for a unspecified period of time allowing all
     * clients to be update.
     *
     * This library maintains the authentication token automatically, so
     * subclasses should only use this method for record keeping.  Subclasses
     * should not override this method to update any {@link C2DMService} or
     * recreate {@link C2DMService} instances.
     *
     * @param newAuthToken  the new authentication token
     */
    public void authTokenUpdated(String newAuthToken);
}
