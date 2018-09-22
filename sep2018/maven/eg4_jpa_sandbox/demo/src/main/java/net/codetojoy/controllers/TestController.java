package net.codetojoy.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping(method=RequestMethod.GET, produces="application/json")
    public @ResponseBody State getState() throws Exception {
        State state = new State();

        Info info = new Info();
        info.isMandatory = true;

        Field f1 = new Field();
        f1.name = "f1";
        f1.value = "v1";
        f1.info = info;

        Field f2 = new Field();
        f2.name = "f2";
        f2.value = "v2";
        f2.info = info;

        state.fields.add(f1);
        state.fields.add(f2);

        state.fieldMap.put(f1.name, f1);
        state.fieldMap.put(f2.name, f2);

        return state;
    }
}

class State {
    public String name = "foo";
    public int id = 5150;
    public List<Field> fields = new ArrayList<Field>();
    public Map<String,Field> fieldMap = new HashMap<String,Field>();
}

class Field {
    public String name;
    public String value;
    public Info info;
}

class Info {
    public boolean isMandatory = false;
    public String label = "";
}
