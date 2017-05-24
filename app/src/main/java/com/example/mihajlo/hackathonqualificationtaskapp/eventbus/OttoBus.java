package com.example.mihajlo.hackathonqualificationtaskapp.eventbus;

import org.androidannotations.annotations.EBean;
import com.squareup.otto.Bus;

/**
 * Created by Mihajlo on 24-May-17.
 */

@EBean(scope = EBean.Scope.Singleton)
public class OttoBus extends Bus {

}
