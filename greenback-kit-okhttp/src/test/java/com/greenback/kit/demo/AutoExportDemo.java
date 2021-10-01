package com.greenback.kit.demo;

import com.greenback.kit.client.GreenbackClient;
import com.greenback.kit.client.GreenbackConstants;
import com.greenback.kit.jackson.JacksonGreenbackCodec;
import com.greenback.kit.okhttp.OkHttpGreenbackClient;
import com.greenback.kit.okhttp.OkHttpHelper;
import okhttp3.OkHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Properties;
import static java.util.Optional.ofNullable;

// TODO JB: need to expand on the demo to test the runs end points. so far this only does the auto exports.
public class AutoExportDemo {
    static private final Logger log = LoggerFactory.getLogger(AutoExportDemo.class);

    static public final void main(String[] args) throws Exception {

        // try to load props from ~/.greenback.conf if it exists
        final Properties config = DemoHelper.userProperties();
        final OkHttpClient httpClient = DemoHelper.httpClient(log);
        final String baseUrl = ofNullable(config.getProperty("base_url"))
            .orElse(GreenbackConstants.ENDPOINT_LOCAL);

        final String accessToken = ofNullable(config.getProperty("access_token"))
            .orElse("access-token-here");

        log.debug(baseUrl);
        log.debug(accessToken);

        try {
            final GreenbackClient client = new OkHttpGreenbackClient(
                httpClient,
                baseUrl,
                new JacksonGreenbackCodec(),
                accessToken);

//            AutoExport create = new AutoExport();
//            create.setUserId("wqVBA0Mj5N");
//            create.setAccountingAccountId("RYj10MDEao");
//            create.setFrequency(AutoExportFrequency.DAILY);
//            create.setState(AutoExportState.ACTIVE);
//            create.setAccountIds(asList("jYkPmlOqnL"));
//
//            AutoExport created = client.createAutoExport(create);
//            log.debug("autoExport: id={}, created={}", create.getId(), create.getCreatedAt());
//
//            final AutoExport export = client.getAutoExportById(created.getId());
//            log.debug("autoExport: id={}, created={}", export.getId(), export.getCreatedAt());
//
//            Paginated<AutoExport> autoExports = client.getAutoExports(new AutoExportQuery());
//            for (AutoExport ae : autoExports) {
//                log.debug("autoExport: {}", ae.getId());
//            }
//
//            AutoExport deleted = client.deleteAutoExportById(created.getId());
//            log.debug("autoExport DELETED: id={}, created={}", export.getId(), export.getCreatedAt());
        }
        catch (Exception e) {
            log.error("Uh oh!", e);
        }
        finally {
            OkHttpHelper.shutdown(httpClient);
        }
    }
}
