package edu.stanford.radx.radxmetadatacompiler;

import edu.stanford.radx.radxmetadatacompiler.cli.CliRunner;
import edu.stanford.radx.radxmetadatacompiler.cli.CreateMetadata;
import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.io.IOException;

@SpringBootApplication
public class RadxMetadataCompilerApplication implements CommandLineRunner, ExitCodeGenerator {

	public static void main(String[] args) {
		SpringApplication.run(RadxMetadataCompilerApplication.class, args);
	}

	@Autowired
	private picocli.CommandLine.IFactory factory;

	@Bean
	public Configuration configuration() throws IOException {
		// Create your Configuration instance, and specify if up to what FreeMarker
		// version (here 2.3.29) do you want to apply the fixes that are not 100%
		// backward-compatible. See the Configuration JavaDoc for details.
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);

		// Specify the source where the template files come from. Here I set a
		// plain directory for it, but non-file-system sources are possible too:
//		cfg.setDirectoryForTemplateLoading(new File("/where/you/store/templates"));

		cfg.setClassForTemplateLoading(RadxMetadataCompilerApplication.class, "/");

		// From here we will set the settings recommended for new projects. These
		// aren't the defaults for backward compatibilty.

		// Set the preferred charset template files are stored in. UTF-8 is
		// a good choice in most applications:
		cfg.setDefaultEncoding("UTF-8");

		// Sets how errors will appear.
		// During web page *development* TemplateExceptionHandler.HTML_DEBUG_HANDLER is better.
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

		// Don't log exceptions inside FreeMarker that it will thrown at you anyway:
		cfg.setLogTemplateExceptions(false);

		// Wrap unchecked exceptions thrown during template processing into TemplateException-s:
		cfg.setWrapUncheckedExceptions(true);

		// Do not fall back to higher scopes when reading a null loop variable:
		cfg.setFallbackOnNullLoopVariable(false);
		return cfg;
	}

	@Autowired
	private ApplicationContext ctx;


	private int exitCode;


	@Override
	public int getExitCode() {
		return exitCode;
	}

	@Override
	public void run(String... args) throws Exception {
		var cliRunner = ctx.getBean(CliRunner.class);
		exitCode = cliRunner.execute(args);
	}

}
