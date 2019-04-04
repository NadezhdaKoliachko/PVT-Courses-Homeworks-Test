import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class vkTest {
    private vkTestMethods vk = new vkTestMethods("d6c5a32bdc8d216867f0db49103598ab41c147ed675" +
            "0844650729984ceaa2f742681a9ad6a4d58c92d6cd", "5.92");


    @Test
    public void assertPostWithPhoto() throws IOException, URISyntaxException {
        String response = vk.postWithPhoto("Пикча с котиками", "photo184715770_392229565",
                "536083852");
        System.out.println(response);
        Assert.assertTrue(response.contains("post_id"));
    }

    @Test
    public void assertWallPost() throws IOException, URISyntaxException {
        String response = vk.postMessage("New post without photo", "536083852");
        System.out.println(response);
        Assert.assertTrue(response.contains("post_id"));
    }

    @Test
    public void assertEditPost() throws IOException, URISyntaxException {
        String response = vk.editPost("I edit this message", "536083852", "421");
        System.out.println(response);
        Assert.assertEquals("{\"response\":1}", response);
    }

    @Test
    public void deletePost() throws IOException, URISyntaxException {
        String response = vk.deletePost("536083852", "421");
        System.out.println(response);
        Assert.assertEquals("{\"response\":1}", response);
    }


}
