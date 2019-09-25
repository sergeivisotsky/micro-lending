package org.sergei.microlending.junit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sergei.microlending.service.interfaces.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Sergei Visotsky
 */
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class UtilTest {

    @SuppressWarnings("unused")
    @Autowired
    private LoanService loanService;

    @Test
    public void identifyUserIp() {
        // TODO
        Assert.fail("Not implemented");
    }
}
