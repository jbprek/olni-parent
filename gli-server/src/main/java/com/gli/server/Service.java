package com.gli.server;

import com.gli.mockdata.MockData;
import com.gli.rest.SWSetInfo;

import javax.ejb.EJB;
import java.util.Map;

/**
 * Created by jvp on 10/11/14.
 */

public class Service {

    public SWSetInfo getSWSetInfo(String alias) {
        return MockData.getSwSetInfoMap().get(alias);
    }

}
