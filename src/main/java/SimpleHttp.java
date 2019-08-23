import com.eclipsesource.v8.JavaCallback;
import com.eclipsesource.v8.NodeJS;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import java.io.File;
import java.io.IOException;


public class SimpleHttp {
    public static void main(String[] args) throws IOException {
        final NodeJS nodeJS = NodeJS.createNodeJS();
        // way to call java method from javascript
        JavaCallback callback = new JavaCallback() {
            public Object invoke(V8Object receiver, V8Array parameters) {
                return "Hello, JavaWorld!";
            }
        };
        nodeJS.getRuntime().registerJavaMethod(callback, "someJavaMethod");

        ReadFile readFile = new ReadFile("node/app.js");
        File nodeScript = readFile.getFileFromResources();
        nodeJS.exec(nodeScript);
        while(nodeJS.isRunning()) {
            nodeJS.handleMessage();
        }
        nodeJS.release();
    }

}
