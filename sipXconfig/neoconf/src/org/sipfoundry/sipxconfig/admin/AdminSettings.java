/**
 * Copyright (c) 2012 eZuce, Inc. All rights reserved.
 * Contributed to SIPfoundry under a Contributor Agreement
 *
 * This software is free software; you can redistribute it and/or modify it under
 * the terms of the Affero General Public License (AGPL) as published by the
 * Free Software Foundation; either version 3 of the License, or (at your option)
 * any later version.
 *
 * This software is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License for more
 * details.
 */
package org.sipfoundry.sipxconfig.admin;

import org.sipfoundry.sipxconfig.setting.PersistableSettings;
import org.sipfoundry.sipxconfig.setting.Setting;
import org.sipfoundry.sipxconfig.setting.SettingEntry;
import org.springframework.beans.factory.annotation.Required;

/**
 * Does not implement DeployOnEdit because we don't need to replicate to other servers
 * and we don't want to restart config server
 */
public class AdminSettings extends PersistableSettings {
    private PasswordPolicy m_passwordPolicy;

    @Override
    public String getBeanId() {
        return "adminSettings";
    }

    @Override
    public void initialize() {
        addDefaultBeanSettingHandler(new AdminSettingsDefaults());
    }

    @Override
    protected Setting loadSettings() {
        Setting adminSetting = getModelFilesContext().loadModelFile("sipxconfig/admin.xml");
        adminSetting.acceptVisitor(m_passwordPolicy);
        return adminSetting;
    }

    public String getSelectedPolicy() {
        return getSettingValue("configserver-config/password-policy");
    }

    public String getDefaultPassword() {
        return getSettingValue("configserver-config/password-default");
    }

    public String getDefaultVmPin() {
        return getSettingValue("configserver-config/vmpin-default");
    }

    @Required
    public void setPasswordPolicy(PasswordPolicy passwordPolicy) {
        m_passwordPolicy = passwordPolicy;
    }

    public class AdminSettingsDefaults {
        @SettingEntry(path = "configserver-config/password-policy")
        public String getDefaultPolicy() {
            return m_passwordPolicy.getDefaultPolicy();
        }
    }
}
