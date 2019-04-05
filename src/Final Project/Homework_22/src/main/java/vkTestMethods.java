import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;

public class vkTestMethods {

    private String accesstoken;
    private String version;

    public vkTestMethods(String accesstoken, String version) {
        this.accesstoken = accesstoken;
        this.version = version;
    }

    public String getAccesstoken() {
        return accesstoken;
    }

    public void setAccesstoken(String accesstoken) {
        this.accesstoken = accesstoken;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    private HttpResponse executeRequest(URIBuilder builder, HttpClient client) throws URISyntaxException, IOException {
        return client.execute(new HttpGet(builder.build()));
    }

    private void baseRequestBuilder(String owner_id, String accessToken, URIBuilder builder,
                                    String version) {
        builder.setParameter("access_token", accessToken)
                .setParameter("owner_id", owner_id)
                .setParameter("v", version);
    }

    public String editPost(String newText, String owner_id, String post_id) throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder builder = new URIBuilder("https://api.vk.com/method/wall.edit");
        baseRequestBuilder(owner_id, getAccesstoken(), builder, getVersion());
        builder.setParameter("message", newText);
        builder.setParameter("post_id", post_id);
        return EntityUtils.toString(executeRequest(builder, client).getEntity());
    }

    public String postMessage(String newText, String owner_id) throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder builder = new URIBuilder("https://api.vk.com/method/wall.post");
        baseRequestBuilder(owner_id, getAccesstoken(), builder, getVersion());
        builder.setParameter("message", newText);
        return EntityUtils.toString(executeRequest(builder, client).getEntity());
    }

    public String deletePost(String owner_id, String post_id) throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder builder = new URIBuilder("https://api.vk.com/method/wall.delete");
        baseRequestBuilder(owner_id, getAccesstoken(), builder, getVersion());
        builder.setParameter("post_id", post_id);
        return EntityUtils.toString(executeRequest(builder, client).getEntity());
    }

    public String postWithPhoto(String message, String photo, String owner_id) throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder builder = new URIBuilder("https://api.vk.com/method/wall.post");
        baseRequestBuilder(owner_id, getAccesstoken(), builder, getVersion());
        builder.setParameter("message", message);
        builder.setParameter("attachments", photo);
        return EntityUtils.toString(executeRequest(builder, client).getEntity());
    }
}

