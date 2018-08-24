package com.puc.tcc.scheduler.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ScheduledFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.puc.tcc.scheduler.controller.validate.TokenValidate;
import com.puc.tcc.scheduler.service.EntregaService;

@EnableScheduling
@RestController
@RequestMapping("")
public class SchedulerController {

	// public String cron = "0 */1 * * * *"; //1m

	public String cron = "0/5 */1 * * * *"; // 5s

	@Autowired
	private TaskScheduler task;
	private ScheduledFuture<?> scheduledFuture;

	private EntregaService entregaService;
	private TokenValidate tokenValidate;

	@Autowired
	public SchedulerController(EntregaService entregaService, TokenValidate tokenValidate) {
		this.entregaService = entregaService;
		this.tokenValidate = tokenValidate;
	}

	@Bean
	public TaskScheduler taskScheduler() {
		return new ConcurrentTaskScheduler(); // single threaded by default
	}

	@GetMapping("start")
	ResponseEntity<Void> start() {
		scheduledFuture = task.schedule(printHour(), new CronTrigger(cron));

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@GetMapping("stop")
	ResponseEntity<Void> stop() {
		scheduledFuture.cancel(false);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	private Runnable printHour() {

		return () -> {

			entregaService.atualizarEntregas();
			System.out.println(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
		};
	}

}